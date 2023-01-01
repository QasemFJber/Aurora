package com.example.qasemtest.Aurora.Activity.Fradment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.qasemtest.Aurora.Activity.AuroraDataBase.Models.Question;
import com.example.qasemtest.Aurora.Activity.Interface.ListenerAnswer;
import com.example.qasemtest.R;
import com.example.qasemtest.databinding.ChooseTheAnswerBinding;
import com.example.qasemtest.databinding.FillInTheBlankBinding;
import com.example.qasemtest.databinding.TrueOrFalseBinding;

import java.math.BigInteger;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayFragment extends Fragment {
    private ListenerAnswer listenerAnswer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *         question.getTitle();
     *
     *
     * */
    private static final String ID = "id";
    private static final String ARG_PATTERN_ID = "pattern_id";
    private static final String ARG_QUESTION_ID = "question_id";
    private static final String ARG_TRUE_ANSWER = "true_answer";
    private static final String ARG_ANSWER_1 = "answer_1";
    private static final String ARG_ANSWER_2 = "answer_2";
    private static final String ARG_ANSWER_3 = "answer_3";
    private static final String ARG_ANSWER_4 = "answer_4";
    private static final String ARG_DURATION = "duration";
    private static final String ARG_LEVEL_ID = "level_id";
    private static final String ARG_HINT = "hint";
    private static final String ARG_POINTS = "points";
    private static final String ARG_TITLE = "title";



    // TODO: Rename and change types of parameters
    private int id ;
    private int pattern_id;
    private int question_id;
    private String answer_1;
    private String answer_2;
    private String answer_3;
    private String answer_4;
    private String answer_true;
    private String hint;
    private String title;
    private int points;
    private int duration;
    private int level_id;


    public PlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ListenerAnswer){
            listenerAnswer = (ListenerAnswer) context;
        }

    }

    // TODO: Rename and change types and number of parameters
    public static PlayFragment newInstance(Question question) {
        PlayFragment fragment = new PlayFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PATTERN_ID, question.getPattern_id());
        args.putInt(ARG_QUESTION_ID, question.getQuestion_Id());
        args.putString(ARG_TRUE_ANSWER, question.getTrue_answer());
        args.putString(ARG_ANSWER_1, question.getAnswer_1());
        args.putString(ARG_ANSWER_2, question.getAnswer_2());
        args.putString(ARG_ANSWER_3, question.getAnswer_3());
        args.putString(ARG_ANSWER_4, question.getAnswer_4());
        args.putInt(ARG_DURATION, question.getDuration());
        args.putInt(ARG_LEVEL_ID, question.getId_level_child());
        args.putString(ARG_HINT, question.getHint());
        args.putInt(ARG_POINTS, question.getPoints());
        args.putString(ARG_TITLE,question.getTitle());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pattern_id = getArguments().getInt(ARG_PATTERN_ID);
            question_id = getArguments().getInt(ARG_PATTERN_ID);
            answer_1 = getArguments().getString(ARG_ANSWER_1);
            answer_2 = getArguments().getString(ARG_ANSWER_2);
            answer_3 = getArguments().getString(ARG_ANSWER_3);
            answer_4 = getArguments().getString(ARG_ANSWER_4);
            answer_true = getArguments().getString(ARG_TRUE_ANSWER);
            hint = getArguments().getString(ARG_HINT);
            title = getArguments().getString(ARG_TITLE);
            duration = getArguments().getInt(ARG_DURATION);
            points = getArguments().getInt(ARG_POINTS);
            level_id = getArguments().getInt(ARG_LEVEL_ID);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        switch (pattern_id){
            case 1:
                TrueOrFalseBinding binding1 = TrueOrFalseBinding.inflate(inflater);
                binding1.tvLevel.setText("Level" + " "+level_id);
                binding1.tvQuestion.setText(title);
                binding1.tvQustion.setText("Question"+" "+question_id);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding1.tvLevel);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding1.tvQustion);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding1.cardquistion);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding1.btnTrue);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding1.btnFalse);
                binding1.btnTrue.setOnClickListener(v ->  {
                    if (answer_true.equals("true")){
                        binding1.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }
                });
                binding1.btnFalse.setOnClickListener(v -> {
                    if (answer_true.equals("true")){
                        binding1.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }
                });
                return binding1.getRoot();
            case 2:
            ChooseTheAnswerBinding binding = ChooseTheAnswerBinding.inflate(inflater);
            binding.tvLevel.setText("Level"+" "+ level_id);
                binding.tvQustion.setText("Question"+" "+question_id);
            binding.tvQuestion.setText(title);
            binding.answer1.setText(answer_1);
            binding.answer2.setText(answer_2);
            binding.answer3.setText(answer_3);
            binding.answer4.setText(answer_4);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding.tvLevel);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding.tvQustion);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding.cardquistion);
                YoYo.with(Techniques.Tada.getAnimator()).repeat(0).duration(2000).playOn(binding.answer1);
                YoYo.with(Techniques.Tada.getAnimator()).repeat(0).duration(2000).playOn(binding.answer2);
                YoYo.with(Techniques.Tada.getAnimator()).repeat(0).duration(2000).playOn(binding.answer3);
                YoYo.with(Techniques.Tada.getAnimator()).repeat(0).duration(2000).playOn(binding.answer4);
                binding.cardanswer1.setOnClickListener(v -> {
                    if (answer_true.equals(answer_1)){
                        binding.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }
                });
                binding.cardanswer2.setOnClickListener(v -> {
                    if (answer_true.equals(answer_2)){
                        binding.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }

                });
                binding.cardanswer3.setOnClickListener(v -> {
                    if (answer_true.equals(answer_3)){
                        binding.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }

                });
                binding.cardanswer4.setOnClickListener(v -> {
                    if (answer_true.equals(answer_4)){
                        binding.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }

                });
            return binding.getRoot();
            case 3:
                FillInTheBlankBinding binding2 = FillInTheBlankBinding.inflate(inflater);
                binding2.tvLevel.setText("Level"+" "+ level_id);
                binding2.tvQustion.setText("Question"+" "+question_id);
                binding2.tvQuestion.setText(title);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding2.tvLevel);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding2.tvQustion);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding2.cardquistion);
                YoYo.with(Techniques.RollIn.getAnimator()).repeat(0).duration(2000).playOn(binding2.btnTest);
                String answer =binding2.eetAnswer.getText().toString().trim();
                binding2.btnTest.setOnClickListener(v -> {
                    if (answer_true.equals(answer)){
                        binding2.tvScore.setText(""+points);
                        listenerAnswer.OnTrueAnswer(question_id);
                    }else {
                        listenerAnswer.OnFalseAnswer(question_id);
                    }
                });

                return binding2.getRoot();

        }
         return null;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listenerAnswer = null;

    }
}