#include <string>
#include <vector>
#include <algorithm>
#include <boost/algorithm/string.hpp>

#include "anagram.h"

using namespace std;
using boost::algorithm::to_lower_copy;

namespace anagram
{
  string normalise_word(string &word)
  {
    string copy = to_lower_copy(word);
    sort(copy.begin(), copy.end());
    return copy;
  }

  bool is_same_word(string lower_cased, string other)
  {
    return lower_cased.compare(to_lower_copy(other)) == 0;
  }

  bool is_anagram(string normed, string candidate)
  {
    return normed.compare(normalise_word(candidate)) == 0;
  }

  anagram::anagram(string base_word)
  {
    this->base_word = base_word;
    base_word_lower = to_lower_copy(base_word);
    base_word_normed = normalise_word(base_word);
  }

  vector<string> anagram::matches(vector<string> candidate_anagrams)
  {
    vector<string> anagrams;
    for (string candidate : candidate_anagrams) {
      if (!is_same_word(base_word_lower, candidate)
      && is_anagram(base_word_normed, candidate)) {
        anagrams.push_back(candidate);
      }
    }
    return anagrams;
  }
}
