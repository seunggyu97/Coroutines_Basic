package com.anushka.coroutinesdemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.anushka.coroutinesdemo1.model.UserRepository
import kotlinx.coroutines.Dispatchers.IO

class MainActivityViewModel : ViewModel() {

    private var usersRepository = UserRepository()

    //    var users: MutableLiveData<List<User>> = MutableLiveData()
//
//    fun getUsers(){
//        viewModelScope.launch {
//            var result: List<User>? = null
//            withContext(IO){
//                result = usersRepository.getUsers()
//            }
//            users.value = result
//        }
//    }
    var users = liveData(IO) {
        val result = usersRepository.getUsers()
        emit(result)
    }
}