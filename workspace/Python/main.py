f = open("/Users/chenguanlin/Downloads/2021.txt")
lies = f.readlines()

sum = 0
for line in lies:
    print(line.strip())
    sum+=int(line.strip())

print(sum)

