#include <string>
#include <iostream>

namespace hamming
{
  
int compute(const std::string a, const std::string b)
{
  if (a.length() != b.length()) { throw std::domain_error("Strings must be same length"); }

  int mismatches = 0;
  for (auto ia = a.cbegin(), ib = b.cbegin(); ia != a.cend(); ia++, ib++) {
    if (*ia != *ib) { mismatches++; }
  }

  return mismatches;
}

}
