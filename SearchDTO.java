package com.pcwk.ehr.member;

import com.pcwk.ehr.cmn.DTO;

public class SearchDTO extends DTO {
	
	//검색조건
	//" ":전체
	//10:상품명
	//20:상품가격
	//30:상품사이즈
	private String searchWord;
	//검색어
	private int searchPrice;
	
	private int searchSize;
	
	public SearchDTO() {
		
	}

	public SearchDTO(String searchWord, int searchPrice, int searchSize) {
		super();
		this.searchWord = searchWord;
		this.searchPrice = searchPrice;
		this.searchSize = searchSize;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getSearchPrice() {
		return searchPrice;
	}

	public void setSearchPrice(int searchPrice) {
		this.searchPrice = searchPrice;
	}

	public int getSearchSize() {
		return searchSize;
	}

	public void setSearchSize(int searchSize) {
		this.searchSize = searchSize;
	}

	@Override
	public String toString() {
		return "SearchDTO [searchWord=" + searchWord + ", searchPrice=" + searchPrice + ", searchSize=" + searchSize
				+ "]";
	}
	
	
}