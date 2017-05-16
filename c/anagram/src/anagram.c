#include <ctype.h>
#include <stdlib.h>
#include <string.h>

#include "anagram.h"

/*
 * expects a lower case string
 * calloc()'s the array it returns, so you had better free() when you're done with it
 */
static int* frequencies(char str[]) {
  int* freqs = calloc(26, sizeof(int));

  for (int i = 0; str[i] != '\0'; ++i) {
    int letter = str[i] - 97;
    if (0 <= letter && letter <= 25) { freqs[letter] += 1; }
  }

  return freqs;
}

/*
 * returns a lower case copy of string
 * calloc()'s an array for the string, so free() when you're done
 */
static char* lowercase(char str[]) {
  char* lower = calloc(MAX_STR_LEN, sizeof(char));

  for (int i = 0; str[i] != '\0'; ++i) {
    lower[i] = (65 <= str[i] && str[i] <= 90)? str[i] + 32 : str[i];
  }

  return lower;
}


static int arrayeq(int a[], int b[], int len) {
  int result = 1;

  for (int i = 0; i < len; ++i) {
    if (a[i] != b[i]) { result = 0; break; }
  }
  free(a);
  free(b);

  return result;
}

/*
 * test if two words are anagrams
 * returns true if the words are not identical (case insensitive)
 * and have the same number of each letter (also case-insensitive)
 */
static int is_anagram(char a[], char b[]) {
  char* a_low = lowercase(a);
  char* b_low = lowercase(b);
  int result = 0;

  if (strcmp(a_low, b_low) != 0 && arrayeq(frequencies(a_low), frequencies(b_low), 26)) { result = 1; }

  free(a_low);
  free(b_low);

  return result;
}

/*
 * returns a `Vector` of the `possibleMatches` which are anagrams of the `word`
 */
struct Vector anagrams_for(char word[], struct Vector possibleMatches) {
  int numMatches = 0;
  char (*matches)[MAX_STR_LEN] = malloc(possibleMatches.size * sizeof(char[MAX_STR_LEN]));

  for (int i = 0; i < possibleMatches.size; i++) {
    if (is_anagram(word, possibleMatches.vec[i])) {
      strcpy(matches[numMatches++], possibleMatches.vec[i]);
    }
  }

  struct Vector result = {
    matches,
    numMatches
  };
  return result;
}
