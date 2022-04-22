function res = KonstantFart(s, s_0, v, t)
if s == 0
	res = s_0 + v*t;
elseif v == 0
	res = (s-s_0)/t;
elseif t == 0
	res = (s-s_0)/v;
elseif s_0 == 0
	res = s - v*t;
end
end

