#if !defined(ANAGRAM)

#define ANAGRAM

#include <string>
#include <vector>

using namespace std;

namespace anagram
{
  class anagram
  {
  private:
    string base_word;
    string base_word_lower;
    string base_word_normed;
  public:
    anagram(string base_word);
    vector<string> matches(vector<string> words);
  };
}

#endif
