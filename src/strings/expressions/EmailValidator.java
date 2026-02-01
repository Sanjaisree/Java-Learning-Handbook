package strings.expressions;

public class EmailValidator {

        public static void main(String[] args) {

            String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$";

            String[] validEmails = {
                    "abc@gmail.com",
                    "user123@yahoo.in",
                    "test.email@domain.org",
                    "name@site.com",
                    "student@college.edu",
                    "mail_box@domain.net",
                    "x@y.co",
                    "hello.world@test.com",
                    "demo@company.in",
                    "simple@mail.com"
            };

            String[] invalidEmails = {
                    "abc@gmail",
                    "abc@.com",
                    "abc.com",
                    "@gmail.com",
                    "abc@gmail..com",
                    "abc@gmail.c",
                    "ab c@gmail.com",
                    "abc@domain",
                    "abc@domain,com",
                    "abc@@gmail.com"
            };

            System.out.println("Valid Emails:");
            for (String email : validEmails) {
                System.out.println(email + " -> " + email.matches(regex));
            }

            System.out.println("\nInvalid Emails:");
            for (String email : invalidEmails) {
                System.out.println(email + " -> " + email.matches(regex));
            }
        }


}
