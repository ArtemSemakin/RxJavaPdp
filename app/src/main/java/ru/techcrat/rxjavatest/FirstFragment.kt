package ru.techcrat.rxjavatest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.techcrat.rxjavatest.adapters.FilmsAdapter
import ru.techcrat.rxjavatest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private val viewModel:FirstViewModel by viewModel()
    private var viewBinding: FragmentFirstBinding? = null
    private val filmAdapter: FilmsAdapter by lazy {
        FilmsAdapter(Glide.with(this))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFirstBinding.inflate(inflater).let {
        viewBinding = it
        initViews()
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFilms()
    }

    private fun initViews() {
        viewBinding?.run {
            with(filmsRv) {
                adapter = filmAdapter
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(
                    DividerItemDecoration(
                        this.context,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

  private fun getFilms(){
      viewModel.filmsLiveData.observe(viewLifecycleOwner){
          filmAdapter.submitList(it)
      }

   }
}
