def is_palindromable(s):
	result = 0
	for i in s:
		result ^= ord(i)
	return result == 0 or chr(result) in s