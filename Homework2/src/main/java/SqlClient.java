public class SqlClient {
    public static void main(String[] args) throws Exception {
        UsersService usersService = new UsersService();
        User user = new User(0, "admin", 4);
        //usersService.update(user);
        usersService.add(user);
        System.out.println(usersService.findAll());
        //System.out.println(usersService.findById(2));
    }
}
