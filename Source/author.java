public class author {
    private String id;
    private String name;
    private String country;
    private String birthYear;
    private Boolean IsAlive;
    public author(String name, String country, String birthYear, Boolean IsAlive, String id){
      this.id = id;
      this.name = name;
      this.country = country;
      this.birthYear = birthYear;
      this.IsAlive = IsAlive;

    }

    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public String getCountry() {
      return country;
    }
    public void setCountry(String country) {
      this.country = country;
    }
    public String getBirthYear() {
      return birthYear;
    }
    public void setBirthYear(String birthYear) {
      this.birthYear = birthYear;
    }
    public Boolean getIsAlive() {
      return IsAlive;
    }
    public void setIsAlive(Boolean IsAlive) {
      this.IsAlive = IsAlive;
    }
}
