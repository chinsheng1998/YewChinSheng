package my.com.yewchinsheng.yewchinsheng;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName, TextViewIC, textViewYearOfBorn, textViewStatus;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            TextViewIC = itemView.findViewById(R.id.textViewIC);
            textViewYearOfBorn = itemView.findViewById(R.id.textViewYearOfBorn);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);
        }
    }

    private final LayoutInflater layoutInflater;
    private List<User> userList;

    public UserAdapter(Context context) { layoutInflater = LayoutInflater.from(context); }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = layoutInflater.inflate(R.layout.user_record, parent, false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int position) {
        if(userList != null){
            User user = userList.get(position);
            userViewHolder.textViewName.setText(user.getName());
            userViewHolder.TextViewIC.setText(user.getIC());
            userViewHolder.textViewYearOfBorn.setText(user.getYearOld());
            userViewHolder.textViewStatus.setText(user.getStatus());
        }else{
            userViewHolder.textViewName.setText("No record.");
        }

    }

    @Override
    public int getItemCount() {
        if(userList != null)
            return userList.size();
        else
            return 0;
    }

    public void setUsers(List<User> users){
        userList = users;
        notifyDataSetChanged(); //Inform ViewModel of any data change
    }


}
