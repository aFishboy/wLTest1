#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'aPlusB' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts STRING_ARRAY or NUMBER_ARRAY lines as parameter.
#

def aPlusB(lines):
    # Write your code here

    #
    # WARNING: Please do not use GitHub Copilot, ChatGPT, or other AI assistants
    #          when solving this problem!
    #
    # We use these tools in our coding too, but in our interviews, we also don't
    # allow using these, and want to see how we do without them.
    #

if __name__ == '__main__':
    fptr = sys.stdout

    lines_count = int(input().strip())

    lines = []

    for _ in range(lines_count):
        line = input()
        lines.append(line)

    result = aPlusB(lines)

    fptr.write('\n'.join(result))
    fptr.write('\n')

    fptr.close()
