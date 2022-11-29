package pojos;

public class GmiBankCostomer {
    public class Costomer {
        private Integer id;
        private  String firstName;
        private  String lastName;
        private  String middleInitial;
        private String email;
        private String mobilePhoneNumber;
        private String phoneNumber;
        private String zipCode;
        private String address;
        private String city;
        private String ssn;
        private String createDate;
        private Boolean zelleEnrolled;

        public Costomer() {
        }

        private GmiBankCountry country;

        public Integer getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Costomer{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", middleInitial='" + middleInitial + '\'' +
                    ", email='" + email + '\'' +
                    ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", zipCode='" + zipCode + '\'' +
                    ", address='" + address + '\'' +
                    ", city='" + city + '\'' +
                    ", ssn='" + ssn + '\'' +
                    ", createDate='" + createDate + '\'' +
                    ", zelleEnrolled=" + zelleEnrolled +
                    ", country=" + country +
                    ", state='" + state + '\'' +
                    ", gmiBankUser=" + gmiBankUser +
                    ", gmiBankAccount=" + gmiBankAccount +
                    '}';
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleInitial() {
            return middleInitial;
        }

        public void setMiddleInitial(String middleInitial) {
            this.middleInitial = middleInitial;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobilePhoneNumber() {
            return mobilePhoneNumber;
        }

        public void setMobilePhoneNumber(String mobilePhoneNumber) {
            this.mobilePhoneNumber = mobilePhoneNumber;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSsn() {
            return ssn;
        }

        public void setSsn(String ssn) {
            this.ssn = ssn;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public Boolean getZelleEnrolled() {
            return zelleEnrolled;
        }

        public void setZelleEnrolled(Boolean zelleEnrolled) {
            this.zelleEnrolled = zelleEnrolled;
        }

        public GmiBankCountry getCountry() {
            return country;
        }

        public void setCountry(GmiBankCountry country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public GmiBankUser getGmiBankUser() {
            return gmiBankUser;
        }

        public void setGmiBankUser(GmiBankUser gmiBankUser) {
            this.gmiBankUser = gmiBankUser;
        }

        public GmiBankAccount getGmiBankAccount() {
            return gmiBankAccount;
        }

        public void setGmiBankAccount(GmiBankAccount gmiBankAccount) {
            this.gmiBankAccount = gmiBankAccount;
        }

        public Costomer(Integer id, String firstName, String lastName, String middleInitial, String email, String mobilePhoneNumber, String phoneNumber, String zipCode, String address, String city, String ssn, String createDate, Boolean zelleEnrolled, GmiBankCountry country, String state, GmiBankUser gmiBankUser, GmiBankAccount gmiBankAccount) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleInitial = middleInitial;
            this.email = email;
            this.mobilePhoneNumber = mobilePhoneNumber;
            this.phoneNumber = phoneNumber;
            this.zipCode = zipCode;
            this.address = address;
            this.city = city;
            this.ssn = ssn;
            this.createDate = createDate;
            this.zelleEnrolled = zelleEnrolled;
            this.country = country;
            this.state = state;
            this.gmiBankUser = gmiBankUser;
            this.gmiBankAccount = gmiBankAccount;
        }

        private String state;
private GmiBankUser gmiBankUser;
private GmiBankAccount gmiBankAccount;

    }}
