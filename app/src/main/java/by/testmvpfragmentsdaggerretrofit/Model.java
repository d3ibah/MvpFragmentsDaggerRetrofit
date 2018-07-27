package by.testmvpfragmentsdaggerretrofit;

public class Model implements MainContract.Model{

    private final String message = "Ошибка!";
    @Override
    public String loadMessage() {
        return message;
    }
}
