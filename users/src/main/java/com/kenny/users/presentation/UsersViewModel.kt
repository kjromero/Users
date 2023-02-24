package com.kenny.users.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kenny.base.viewmodel.BaseViewModel
import com.kenny.users.domain.usescases.GetPostsByUserUseCase
import com.kenny.users.domain.usescases.GetUsersListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersListUseCase: GetUsersListUseCase,
    private val getPostsByUserUseCase: GetPostsByUserUseCase,
) : BaseViewModel() {

    private val _data = MutableLiveData(UsersUiState())
    val data = _data as LiveData<UsersUiState>

    init {
        getUsers()
    }

    private fun getUsers() {
        disposables.add(
            getUsersListUseCase.execute(Unit)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _data.value = data.value?.copy(
                        isLoading = true,
                    )
                }
                .doOnTerminate {
                    _data.value = data.value?.copy(
                        isLoading = false,
                    )
                }
                .subscribe(
                    {
                        _data.value = data.value?.copy(
                            users = it,
                        )
                    },
                    {
                        _data.value = data.value?.copy(
                            isError = true
                        )
                    }
                )
        )
    }

    fun getPostsByUser(userId: Int) {
        disposables.add(
            getPostsByUserUseCase.execute(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    _data.value = data.value?.copy(
                        isLoading = true,
                    )
                }
                .doOnTerminate {
                    _data.value = data.value?.copy(
                        isLoading = false,
                    )
                }
                .subscribe(
                    {
                        _data.value = data.value?.copy(
                            posts = it,
                        )
                    },
                    {
                        _data.value = data.value?.copy(
                            isError = true
                        )
                    }
                )
        )
    }

    fun clearPosts() {
        _data.value = data.value?.copy(
            posts = emptyList()
        )
    }
}