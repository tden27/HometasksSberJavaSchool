package lesson5.beanUtils;

public class Main {
    public static void main(String[] args) {
        ObjectFrom objectFrom = new ObjectFrom(1,2,3,"5");
        ObjectTo objectTo = new ObjectTo();
        BeanUtils.assign(objectTo, objectFrom);
        System.out.println(objectTo.getaFrom());
        System.out.println(objectTo.getbFrom());
        System.out.println(objectTo.getcFrom());
        System.out.println(objectTo.getdFrom());
    }
}
