public interface Customer {

    enum CustomerType{FACULTY, STUDENT, GUEST}
    double GetPriceModifier(CustomerType CT);


}
