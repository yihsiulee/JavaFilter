public class Member {
    String firstname;
    String lastname;
    int age;
    public Member(String firstname, String lastname, int age) {
        this.firstname = firstname;
	this.lastname = lastname;
        this.age = age;
    }
    public String toString() {
        return firstname + " " + lastname + " age=" + age;
    }
}
