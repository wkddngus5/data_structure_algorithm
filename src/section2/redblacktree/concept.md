# Red-black Tree


## 정의
- 각 노드는 red 혹은 black이다
- Root는 black이다.
- 각 leaf(NUL)은 black이다
- 노드가 red라면 두 개의 children은 모두 black이다.
- 각 노드에 대해서 노드로부터 descendant leaves까지의 단순 경로는 모두 같은 수의 black nodes들을 포함하고 있다

## Red-black Tree의 특징
 - Binary Search Tree
 - 각 노드는 Red 혹은 Black 색깔을 가진다.
 - Root부터 leaf까지의 모든 경로 중 최소 경로와 최대 경로의 크기 비율은 2보다 크지 않다
    > Balanced 상태
 - 노드의 child가 없을 경우 child를 가리키는 포인터는 NIL값을 저장한다
    > 이러한 NIL들을 leaf node로 간주한다.
    
### Black-Height
- 노드 x로부터 노드 x를 포함하지 않은 leaf node까지의 simple path상에 있는 black nodes의 개수
- bh(x)로 표기

