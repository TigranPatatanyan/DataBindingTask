import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel() {

    var username: MutableLiveData<String> = MutableLiveData()
    var password: MutableLiveData<String> = MutableLiveData()

    fun getBoolean(): Boolean {
        return username.toString().length > 6 && password.toString().length > 6
    }
    fun changeUsernameText(text:String){
        username.value=text
    }
    fun changePasswordText(text:String){
        username.value=text
    }
}