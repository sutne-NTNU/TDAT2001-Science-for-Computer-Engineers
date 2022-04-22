function res = Newton2(F, m, a)
if F == 0
	res = m*a;
elseif m == 0
	res = F/a;
elseif a == 0
	res = F/m;
end

