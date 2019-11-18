package task01;

class Country {
    private String code;
    private String name;
    private int peopleNumber;

    Country(String code, String name, int peopleNumber) {
        this.code = code;
        this.name = name;
        this.peopleNumber = peopleNumber;
    }

    @Override
    public String toString() {
        return name + " (" + code + ") ma " + peopleNumber + " ludności.";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
}
