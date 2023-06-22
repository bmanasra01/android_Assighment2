package com.example.assighment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private List<Question> questions;

    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = questions.get(position);

        holder.questionTextView.setText(question.getQuestionText());
        holder.optionATextView.setText(question.getOptionA());
        holder.optionBTextView.setText(question.getOptionB());
        holder.optionCTextView.setText(question.getOptionC());
        holder.optionDTextView.setText(question.getOptionD());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView questionTextView;
        public RadioButton optionATextView;
        public RadioButton optionBTextView;
        public RadioButton optionCTextView;
        public RadioButton optionDTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
            optionATextView = itemView.findViewById(R.id.optionARadioButton);
            optionBTextView = itemView.findViewById(R.id.optionBRadioButton);
            optionCTextView = itemView.findViewById(R.id.optionCRadioButton);
            optionDTextView = itemView.findViewById(R.id.optionDRadioButton);
        }
    }
}
