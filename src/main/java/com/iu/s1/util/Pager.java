package com.iu.s1.util;

public class Pager {
	// 페이지당 보여줄 row의 갯수
	private Long perPage;
	// 페이지 번호
	private Long page;

	// 시작번호
	private Long startRow;
	// 끝번호
	private Long lastRow;
	
	//------검색에서 사용하는 변수 -----
	private String search;
	private String kind;
	

	// -----JSP 사용 변수-----
	private Long startNum;
	private Long lastNum;

	private boolean pre;
	private boolean next;

	public void makeRow() {
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		this.lastRow = this.getPage() * this.getPerPage();
	}

	
	public void makeNum(Long totalCount) {
		// 1. 전체 row 갯수 구하기
		// Long totalCount = 409L;
		// 2. 전체 페이지 갯수 구하기
		Long totalpage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0) {
			totalpage++;
		}
		// 3. 블럭당 갯수
		Long perBlock = 10L;

		// 4. 전체 블럭의 갯수
		Long totalBlock = totalpage / perBlock;
		if (totalpage % perBlock != 0) {
			totalBlock++;
		}

		// 5. 페이지번호로 현재 몇번째 블럭인지 계산
		// 1번 : 1~10
		// 2번 : 11~20

		// page block
		// 1 1
		// 2 1
		// ...
		// 9 1
		// 10 1
		// 11 2
		// 20 2
		// 21 3
		Long curBlock = this.getPage() / perBlock;
		if (this.getPage() % perBlock != 0) {
			curBlock++;
		}

		// 6. curBlock(현재블럭)로 startNum, lastNum 구하기
		// curBlock startNum lastNum
		// 1 1 10
		// 2 11 20

		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;
		
		// 7. 이전, 다음 블럭 유무
		this.pre=false;
		if(curBlock>1) {
		//현재 블럭이 2,3,4...
			this.pre=true;
		}
		
		this.next=false;
		if(totalBlock > curBlock) {
			this.next= true;
		}
		// 8. 현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock==totalBlock) {
			this.lastNum=totalpage;
		}
		
		//9. 검색결과가 없어서 Total이 0일때
		if(totalCount==0) {
			this.lastNum=1L;
		}

	}

	public Long getPerPage() {
		if (this.perPage == null || this.perPage < 1) {
			this.perPage = 10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
		if (this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		//this.search="%"+this.search+"%";
		return search;
	
	}

	public void setSearch(String search) {
		this.search = search;
	}


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	

}
