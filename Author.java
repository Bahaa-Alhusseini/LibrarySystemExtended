class Author {
  private int id;
  private String name;
  private String address;
  private String birthDate;

  public Author(int id, String name, String address, String birthDate) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.birthDate = birthDate;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public String getInfo() {
    return "ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nBirth Date: " + birthDate;
  }
}
