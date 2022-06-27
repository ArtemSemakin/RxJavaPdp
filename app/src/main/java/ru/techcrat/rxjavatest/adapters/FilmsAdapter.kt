package ru.techcrat.rxjavatest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.techcrat.rxjavatest.databinding.RecyclerElemBinding
import ru.techcrat.rxjavatest.models.Film
import ru.techcrat.rxjavatest.networkModels.FilmModel

class FilmsAdapter(private val glide: RequestManager) :
    ListAdapter<Film, FilmsAdapter.FilmsViewHolder>(DIFF_CALLBACK) {

    inner class FilmsViewHolder(
        private val binding: RecyclerElemBinding,
        private val glide: RequestManager
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Film) {
            binding.filmName.text = item.title
            binding.filmDescription.text = item.description
            glide
                .load(item.image)
                .into(binding.filmIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder =
        FilmsViewHolder(
            RecyclerElemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            glide
        )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Film>() {

    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean = oldItem == newItem
    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean = oldItem == newItem
}
