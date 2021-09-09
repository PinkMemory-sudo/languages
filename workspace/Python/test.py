import pandas as pd

csv = pd.read_csv("/Users/chenguanlin/Documents/output.csv", sep="\t", encoding="utf-8", chunksize=60000)
num = 1

for i in csv:
    print(num)
    i.to_excel("/Users/chenguanlin/Documents/2775/test%s.xlsx" % num)
    num += 1
