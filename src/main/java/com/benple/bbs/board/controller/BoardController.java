package com.benple.bbs.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.benple.bbs.board.domain.BoardVO;
import com.benple.bbs.board.domain.FileVO;
import com.benple.bbs.board.service.BoardService;

@Controller
public class BoardController {
	
	@Resource(name="com.benple.bbs.board.service.BoardService")
	BoardService mBoardService;
	
	@RequestMapping("/list")//게시판 리스트 화면 호출 
	private String boardList(Model model) throws Exception{
		
		model.addAttribute("list", mBoardService.boardListService());
		
		return "list";//생성할 jsp
	}
	
	@RequestMapping("/detail/{board_seq}")//상세뷰 호출 
	private String boardDetail(@PathVariable int board_seq, Model model) throws Exception{
		
		model.addAttribute("detail", mBoardService.boardDetailService(board_seq));
		model.addAttribute("files", mBoardService.fileDetailService(board_seq));
		
		return "detail";
	}
	
	@RequestMapping("/insert")//게시글 작성폼 호출
	private String boardInsertFrom(){
		
		return "insert";
	}
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception{
		
		BoardVO board = new BoardVO();
		FileVO file = new FileVO();
		
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setWriter(request.getParameter("writer"));
		
		if(files.isEmpty()){
			mBoardService.boardInsertService(board);
		}else{
			String fileName = files.getOriginalFilename();
			String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase();
			File destinationFile;
			String desinationFilename;
			String fileUrl = "/Users/dj/Documents/workspace/BBS/src/main/webapp/WEB-INF/uploadFiles/";	
			
		do{
			desinationFilename = RandomStringUtils.randomAlphanumeric(32) +"."+fileNameExtension;
			destinationFile = new File(fileUrl + desinationFilename);
		} while (destinationFile.exists());
		
		destinationFile.getParentFile().mkdirs();
		files.transferTo(destinationFile);
		
		mBoardService.boardInsertService(board);
		
		file.setBoard_seq(board.getBoard_seq());
		file.setFileName(desinationFilename);
		file.setFileOriName(fileName);;
		file.setFileUrl(fileUrl);
		
		mBoardService.fileInsertService(file);
	    }
		
		return "redirect:/list";
	}
	
	@RequestMapping("/update/{board_seq}")//게시글 수정폼 호출
	private String boardUpdateForm(@PathVariable int board_seq, Model model) throws Exception{
		
		model.addAttribute("detail", mBoardService.boardDetailService(board_seq));
		
		return "update";
	}

	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception{
		
		BoardVO board = new BoardVO();
		board.setSubject(request.getParameter("subject"));
		board.setContent(request.getParameter("content"));
		board.setBoard_seq(Integer.parseInt(request.getParameter("board_seq")));
		
		mBoardService.boardUpdateService(board);
		
		
		
		return "redirect:/detail/"+request.getParameter("board_seq");
	}
	
	
	@RequestMapping("/delete/{board_seq}")
	private String boardDelete(@PathVariable int board_seq) throws Exception{
		
		mBoardService.boardDeleteService(board_seq);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/fileDown/{board_seq}")
	private void fileDown(@PathVariable int board_seq, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		FileVO fileVO = mBoardService.fileDetailService(board_seq);
		
		//파일 업로드된 경로
		try{
			String fileUrl = fileVO.getFileUrl();
			fileUrl += "/";
			String savePath = fileUrl;
			String fileName = fileVO.getFileName();
			
			//실제 내보낼 파일명
			String oriFileName = fileVO.getFileOriName();
			InputStream in = null;
			OutputStream os = null;
			File file = null;
			boolean skip = false;
			String client = "";
			
			//파일을 읽어 스트림에 담기
			try{
				file = new File(savePath, fileName);
				in = new FileInputStream(file);
			} catch (FileNotFoundException fe) {
				skip = true;
			}
			
			client = request.getHeader("User-Agent");
			
			//파일 다운로드 헤더 지정
			response.reset();
			response.setContentType("application/octet-streem");
			response.setHeader("Content-Description", "JSP Generated Data");
			
			if (!skip){
				// IE
				if (client.indexOf("MSIE")!= -1){
					response.setHeader("Content-Disposition", "attachment;filename=\""
							+java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\")+"\"");
				// IE 11 이상.
				} else if (client.indexOf("MSIE")!=-1){
					response.setHeader("Content-Disposition", "attachment;filename=\""
							+java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\")+"\"");
				}else {
					//한글 파일명 처리 
					response.setHeader("Content-Disposition", 
							"attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"),"ISO8859_1")+"\"");
					response.setHeader("Content-Type", "application/octet-stream; chaset=utf-8"); 
				}
				response.setHeader("Content-Length", ""+file.length());
				os = response.getOutputStream();
				byte b[] = new byte[(int)file.length()];
				int leng = 0;
				while ((leng = in.read(b)) > 0) {
					os.write(b, 0, leng);
					}	
				}else{
					response.setContentType("text/html;charset=UTF-8");
					System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
				}
				in.close();
				os.close();
			}catch (Exception e){
				System.out.println("ERROR:" + e.getMessage());
			}
		}
			
	}
	

