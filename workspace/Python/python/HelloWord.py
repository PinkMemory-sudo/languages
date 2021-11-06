print('hello word')

# 输出数字，字符串和表达式
print(100)
print(1+1)
print(1==1)

# 可以输出到文件中
fp=open('./test.txt','a+')
print('hello',file=fp)
fp.close()

# 字符串最后一个字符不能是反斜杠

# 输出多个内容，可以用,隔开
print('tom','jack')
print(1,1)

# 转义字符
print('hello\rword')
print('hello\bword')

# 取消转义，让字符串原样输出,字符串前加r或者R
print(r'hello\rword')
print(R'hello\bword')