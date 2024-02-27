print("hello")
for i in range(5):
    print(str(i) * i)
    if i < 2:
        print(str(i) + " is neither prime nor composite.")
    elif i < 4:
        print(str(i) + " is prime.")
    else:
        print(str(i) + " is composite.")

        

