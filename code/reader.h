#ifndef _READER_H_
#define _READER_H_

#include <vector>
#include <fstream>

typedef graph vector< vector < int >* >

class reader
{
  graph readFile(ifstream F);
};

#endif
