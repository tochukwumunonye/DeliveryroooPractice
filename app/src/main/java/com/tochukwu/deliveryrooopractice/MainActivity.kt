package com.tochukwu.deliveryrooopractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}



/**

class UserAdapter @Inject constructor(
private val glide: RequestManager
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
val ivProfilePicture: ImageView = itemView.ivProfileImage
val tvUsername: TextView = itemView.tvUsername
}
private val diffCallback = object: DiffUtil.ItemCallback<User>() {
override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
return oldItem.hashCode() == newItem.hashCode()
}

override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
return oldItem.uid == newItem.uid
}
}

private val differ = AsyncListDiffer(this, diffCallback)

var users: List<User>
get() = differ.currentList
set(value) = differ.submitList(value)

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
return UserViewHolder(
LayoutInflater.from(parent.context).inflate(
R.layout.item_user,
parent,false
)
)
}

override fun getItemCount(): Int {
return users.size
}

override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
val user = users[position]
holder.apply{
glide.load(user.profilePictureUrl).into(ivProfilePicture)
tvUsername.text = user.username
itemView.setOnClickListener {
onUserClickListener?.let{click ->
click(user)

}
}
}
}

private var onUserClickListener: ((User) -> Unit)? = null

fun setOnUserClickListener(listener: (User) -> Unit) {
onUserClickListener = listener
}
}
        **/