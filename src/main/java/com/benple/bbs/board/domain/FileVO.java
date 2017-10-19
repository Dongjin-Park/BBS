package com.benple.bbs.board.domain;

public class FileVO {

	private int file_seq;
	private int board_seq;
	private String fileName;    //저장할 파일 
	private String fileOrName;  //실제 파일 
	private String fileUrl;
	
	
	public int getFile_seq() {
		return file_seq;
	}
	public void setFile_seq(int file_seq) {
		this.file_seq = file_seq;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOrName() {
		return fileOrName;
	}
	public void setFileOrName(String fileOrName) {
		this.fileOrName = fileOrName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
