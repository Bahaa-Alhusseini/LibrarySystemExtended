class Journal extends Book {
  private String conferenceName;
  private int conferenceNo;

  public Journal(String title, String author, int no, String genre, int version, String date, String conferenceName,
      int conferenceNo) {
    super(title, author, no, genre, version, date);
    this.conferenceName = conferenceName;
    this.conferenceNo = conferenceNo;
  }

  public String getConferenceName() {
    return conferenceName;
  }

  public int getConferenceNo() {
    return conferenceNo;
  }

  public String getInfo() {
    return super.getInfo() + "\nConference Name: " + conferenceName + "\nConference No: " + conferenceNo;
  }
}
