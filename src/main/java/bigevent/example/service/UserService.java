package bigevent.example.service;

import bigevent.example.pojo.User;

public interface UserService {
    // 查询
    public User findByUserName(String username);
    // 注册
    public void register(String username, String password);

    // 更新
    void update(User user);

    // 更新头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String newPwd);
}
