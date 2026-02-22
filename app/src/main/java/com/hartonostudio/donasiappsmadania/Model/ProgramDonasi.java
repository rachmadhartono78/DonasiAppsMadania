package com.hartonostudio.donasiappsmadania.Model;

public class ProgramDonasi {
    private String title;
    private String imageUrl;
    private long targetAmount;
    private long collectedAmount;

    public ProgramDonasi(String title, String imageUrl, long targetAmount, long collectedAmount) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.targetAmount = targetAmount;
        this.collectedAmount = collectedAmount;
    }

    public String getTitle() { return title; }
    public String getImageUrl() { return imageUrl; }
    public long getTargetAmount() { return targetAmount; }
    public long getCollectedAmount() { return collectedAmount; }

    public int getProgress() {
        if (targetAmount == 0) return 0;
        return (int) ((collectedAmount * 100) / targetAmount);
    }
}
