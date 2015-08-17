def listsum1(numList):
    theSum = 0
    for i in numList:
        theSum = theSum + i
    return theSum


def listsum2(numList):
	if(len(numList)>1):
		total = numList[0] + listsum2(numList[1:])
	else:
		total = numList[0]

	return total



