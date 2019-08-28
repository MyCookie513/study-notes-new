/****


 int BinarySearchMax(const std::vector<int>& data, int target)

 {

    int left = 0;

    int right = data.size()-1;

    while (left < right) {

    int mid = (left + right) / 2;

    if (data[mid] < target)

       left = mid +1;

    else

       right = mid ;
    }

    if (data[right] == target)

      return right;

    return -1;

 }






 */