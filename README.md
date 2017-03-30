# ai-project tic-toc-game

##

这是一个神秘的game

输入一个O 你将得到一个计算机绞尽脑汁找到的一个X （10min内）

算法使用老师提供的MINIMAX算法，eval()函数不期将改进（如果我能想出来的话

>```
function ALPHA-BETA-SEARCH(state) returns an action
v ← MAX-VALUE(state, min_utility, max_utility)
return the action in ACTIONS(state) with value v
function MAX-VALUE(state, α, β) returns a utility value
if TERMINAL-TEST(state) then return UTILITY(state)
v ← -∞
for the next a in ACTIONS(state) do
v ← MAX(v, MIN-VALUE(RESULT(state, a), α, β))
if v ≥ β then return v
α← MAX(α, v)
return v
function MIN-VALUE(state, α, β) returns a utility value
if TERMINAL-TEST(state) then return UTILITY(state)
v ← +∞
for the next a in ACTIONS(state) do
v ← MIN(v, MAX-VALUE(RESULT(state, a), α, β))
if v ≤ α then return v
β ← MIN(β, v)
return v
```

好吧，我编不下去了，详细资料请参阅档案内的pdf文档，感谢支持，笔芯♥

参考资料
1. [MARKDOWN新手指南](http://www.jianshu.com/p/q81RER)
