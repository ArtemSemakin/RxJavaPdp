package ru.techcrat.rxjavatest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.techcrat.rxjavatest.models.Film
import ru.techcrat.rxjavatest.usecases.ListOfFilmsUseCase

class FirstViewModel(private val useCase: ListOfFilmsUseCase) : ViewModel() {

    val filmsLiveData = MutableLiveData<List<Film>>()
    private var dispose: CompositeDisposable? = null

    init {
        dispose = CompositeDisposable()
        films()
    }


    private fun films() =
        dispose?.add(useCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .cache()
            .subscribe {
                filmsLiveData.postValue(it)
            }
        )

//    private fun funnnyFun() {
//        Observable.just("string", "superString", "megaString")
//            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//            .flatMap {
//                Observable.just(it + "5", it + "6")
//            }
//            .subscribe() {
//                Log.d("FILM", it)
//            }
//    }

    override fun onCleared() {
        super.onCleared()
        dispose?.dispose()
        dispose = null
    }


}
