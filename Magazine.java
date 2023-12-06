class Magazine extends Book {
  private int issueNo;
  private String releaseDate;

  public Magazine(String title, String author, int no, String genre, int version, String date, int issueNo,
      String releaseDate) {
    super(title, author, no, genre, version, date);
    this.issueNo = issueNo;
    this.releaseDate = releaseDate;
  }

  public int getIssueNo() {
    return issueNo;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public String getInfo() {
    return super.getInfo() + "\nIssue No: " + issueNo + "\nRelease Date: " + releaseDate;
  }
}
