package my.com.yewchinsheng.yewchinsheng;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        allUsers = userRepository.getAllUsers();

    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public  void insertUser(User user){
        userRepository.insertUser(user);
    }
}
