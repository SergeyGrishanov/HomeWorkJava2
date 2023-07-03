

// Дана строка sql-запроса"select * from students where ".
// Сформируйте часть WHERE этого запроса,используя StringBuilder.Данные для фильтрации приведены ниже в виде json строки.
//Если значение null,то параметр не должен попадать в запрос.

// Параметры для фильтрации:{"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}

package work1;

public class work1 {
    public static final String QUERY = "select * from students where ";
    public static final String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";

    public static void main(String[] args) {
        String paramsNew = PARAMS.replace('{', ' ').replace('}', ' ');
        String[] parameters = paramsNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(QUERY);
        for (int i = 0; i < parameters.length; i++) {
            String[] elements = parameters[i].replace('"', ' ').split(":");
            if (!"null".equals(elements[1].trim())) {
                stringBuilder.append(elements[0].trim()).append(" = ").append("'").append(elements[1].trim()).append("'");
                if (i < parameters.length - 2)
                    stringBuilder.append(" and ");
            }
        }
        System.out.println(stringBuilder);
    }
}