#include <stdio.h>
#include <stddef.h>
#include "hello_world.h"

void hello(char* buffer, const char* name)
{
  name = (NULL == name)? "World" : name;
  sprintf(buffer, "Hello, %s!", name);
}
