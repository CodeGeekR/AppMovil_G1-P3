package com.grupounoptresunal.kamaleon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.grupounoptresunal.kamaleon.ui.adapters.CommentAdapter
import com.grupounoptresunal.kamaleon.data.models.Comment
import com.grupounoptresunal.kamaleon.databinding.FragmentCommentBinding
import com.grupounoptresunal.kamaleon.ui.viewmodels.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CommentFragment : Fragment() {

    private var _binding: FragmentCommentBinding? = null
    private val binding get() = _binding!!

    private lateinit var commentAdapter: CommentAdapter
    private lateinit var commentManager: GridLayoutManager
    private val commentViewModel : CommentViewModel by viewModel()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_comment, container, false)
        _binding = FragmentCommentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        commentViewModel.loadComments()
        commentAdapter = CommentAdapter(
            listOf()
        )
        commentManager = GridLayoutManager(requireContext(), 1)
        binding.commentRecycler.apply {
            adapter =commentAdapter
            layoutManager = commentManager
        }
        observeViewModels()
    }
    private fun observeViewModels(){
        commentViewModel.comments.observe(viewLifecycleOwner, Observer { comments ->
            commentAdapter.newDataSet(comments)

        })
    }

}