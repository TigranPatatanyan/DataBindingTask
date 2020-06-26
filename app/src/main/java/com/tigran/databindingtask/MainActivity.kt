import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.tigran.databindingtask.SecondActivity
import com.tigran.databindingtask.R
import com.tigran.databindingtask.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.executePendingBindings()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        user_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                (viewModel as MainViewModel).changeUsernameText(p0.toString())
            }
        })
        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                (viewModel as MainViewModel).changePasswordText(p0.toString())
            }
        })
    }

    fun login(view: View) {
        if ((viewModel as MainViewModel).getBoolean()) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("username", user_name.text)
            intent.putExtra("password", password.text)
        } else Toast.makeText(
                this,
                "username and password password must be at least 6 characters long",
                Toast.LENGTH_SHORT
        ).show()
    }
}