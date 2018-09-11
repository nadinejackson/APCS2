//Team rm-rf : Nadine Jackson, Raunak Chowdhury, T. Fabiha
//APCS2 Pd2
//HW #52: Grow & Shrink
//2018-05-23 w

boolean grow = false;
int size = 0;

void setup()
{
  size(500, 500);
  background(0, 0, 0);
}

void draw()
{
  if (grow)
    size += 5;
  else if (size > 0)
    size -= 5;

  background(0, 0, 0);
  ellipse(mouseX, mouseY, size, size);
  fill(18, 152, 229);
}

void mouseClicked()
{
  grow = !grow;
}
