package com.hartonostudio.donasiappsmadania.Menu.Home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hartonostudio.donasiappsmadania.Model.ProgramDonasi;
import com.hartonostudio.donasiappsmadania.databinding.ItemProgramDonasiBinding;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProgramDonasiAdapter extends RecyclerView.Adapter<ProgramDonasiAdapter.ViewHolder> {

    private List<ProgramDonasi> programList;

    public ProgramDonasiAdapter(List<ProgramDonasi> programList) {
        this.programList = programList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProgramDonasiBinding binding = ItemProgramDonasiBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProgramDonasi program = programList.get(position);
        holder.bind(program);
    }

    @Override
    public int getItemCount() {
        return programList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemProgramDonasiBinding binding;

        public ViewHolder(ItemProgramDonasiBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ProgramDonasi program) {
            binding.tvTitle.setText(program.getTitle());
            binding.pbDonation.setProgress(program.getProgress());
            
            NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
            binding.tvCollectedAmount.setText(formatter.format(program.getCollectedAmount()));
            
            // Glide integration would go here
            // Glide.with(binding.ivProgram.getContext()).load(program.getImageUrl()).into(binding.ivProgram);
        }
    }
}
