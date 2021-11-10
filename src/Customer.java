public interface Customer {

    enum CustomerType{FACULTY, STUDENT, GUEST}
    CustomerType GetTypeOfCustomer();
    double GetPriceModifier(CustomerType CT);


}
