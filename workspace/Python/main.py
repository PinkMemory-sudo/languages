
total_loss = 590.25
loss_rate = 0.0894
today_gain = 29.96
today_rate = 0.0051

print((total_loss + today_gain) * (loss_rate + today_rate) * (1 + ((loss_rate + today_rate) * 100 // 5)))
