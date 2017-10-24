<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
var board_seq = '${detail.board_seq}'; //게시글 번호

$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
    commentInsert(insertData); //Insert 함수호출(아래)
});
 


//댓글 목록 
function commentList(){
    $.ajax({
        url : '/comment/list/${board_seq}',
        type : 'get',
        data : {'board_seq':board_seq},
        success : function(data){
            var a =''; 
            $.each(data, function(key, value){ 
                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
                a += '<div class="commentInfo'+value.comment_seq+'">'+'댓글번호 : '+value.comment_seq+' / 작성자 : '+value.writer;
                a += '<a onclick="commentUpdate('+value.comment_seq+',\''+value.content+'\');"> 수정 </a>';
                a += '<a onclick="commentDelete('+value.comment_seq+');"> 삭제 </a> </div>';
                a += '<div class="commentContent'+value.comment_seq+'"> <p> 내용 : '+value.content +'</p>';
                a += '</div></div>';
            });
            
            $(".commentList").html(a);
        }
    });
}


//댓글 등록
function commentInsert(insertData){
    $.ajax({
        url : '/comment/insert',
        type : 'post',
        data : insertData,
        success : function(data){
            if(data == 1) {
                commentList(); //댓글 작성 후 댓글 목록 reload
                $('[name=content]').val('');
            }
        }
    });
}
 
//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
function commentUpdate(comment_seq, content){
    var a ='';
    
    a += '<div class="input-group">';
    a += '<input type="text" class="form-control" name="content_'+comment_seq+'" value="'+content+'"/>';
    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+comment_seq+');">수정</button> </span>';
    a += '</div>';
    
    $('.commentContent'+comment_seq).html(a);
    
}
 
//댓글 수정
function commentUpdateProc(comment_seq){
    var updateContent = $('[name=content_'+comment_seq+']').val();
    
    $.ajax({
        url : '/comment/update',
        type : 'post',
        data : {'content' : updateContent, 'comment_seq' : comment_seq},
        success : function(data){
            if(data == 1) commentList(board_seq); //댓글 수정후 목록 출력 
        }
    });
}
 
//댓글 삭제 
function commentDelete(comment_seq){
    $.ajax({
        url : '/comment/delete/'+comment_seq,
        type : 'post',
        success : function(data){
            if(data == 1) commentList(board_seq); //댓글 삭제후 목록 출력 
        }
    });
}
 
 
 
 
$(document).ready(function(){
    commentList(); //페이지 로딩시 댓글 목록 출력 
});


</script>
